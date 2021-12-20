package _01_array_list_visualizer.data;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JPanel;

@SuppressWarnings("unchecked")
public class ArrayList<T> {
	public ArrayListDisplayPanel<T> displayPanel;
	T[] list;
	private T[] expectedList;

	public ArrayList() {
		list = (T[]) new Object[0];
		expectedList = (T[]) new Object[0];
		displayPanel = new ArrayListDisplayPanel<T>(this);
	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index - index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException
	 */
	public T get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > expectedList.length)
			throw new IndexOutOfBoundsException();
		return expectedList[index];
	}

	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param e - element to be appended to this list
	 * @return true (as specified by Collection.add(E))
	 */
	public boolean add(T e) {
		// Expected list
		T[] nList = (T[]) new Object[expectedList.length + 1];
		for (int i = 0; i < expectedList.length; i++)
			nList[i] = expectedList[i];
		nList[nList.length - 1] = e;
		expectedList = nList;

		// Display list
		Action<T> action = new Action<T>(Action.ADD, -1, e);
		action.x = ArrayListDisplayPanel.WIDTH + 50;
		action.y = displayPanel.listGraphicsHeight;
		return displayPanel.actionQueue.add(action);
	}

	/**
	 * Inserts the specified element at the specified position in this list. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices).
	 * 
	 * @param index   - index at which the specified element is to be inserted
	 * @param element - element to be inserted
	 * @throws IndexOutOfBoundsException
	 * @return true (as specified by Collection.add(E))
	 */
	public boolean add(int index, T element) throws IndexOutOfBoundsException {
		// Expected list
		T[] nList = (T[]) new Object[expectedList.length + 1];
		for (int i = 0; i < index; i++)
			nList[i] = expectedList[i];
		nList[index] = element;
		for (int i = index; i < expectedList.length; i++)
			nList[i + 1] = expectedList[i];
		expectedList = nList;

		// Display list
		Action<T> action = new Action<T>(Action.INSERT, index, element);
		action.x = ArrayListDisplayPanel.WIDTH + 50;
		action.y = displayPanel.listGraphicsHeight - 100;
		return displayPanel.actionQueue.add(action);
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 * 
	 * @param index   - index of the element to replace
	 * @param element - element to be stored at the specified position
	 * @return The element previously at the specified index
	 * @throws IndexOutOfBoundsException - if the index is out of range(index < 0 ||
	 *                                   index >= size())
	 */
	public T set(int index, T element) throws IndexOutOfBoundsException {
		T e = get(index);
		// Expected list
		T[] nList = expectedList.clone();
		nList[index] = element;
		expectedList = nList;

		// Display list
		Action<T> action = new Action<T>(Action.SET, index, element);
		action.x = ArrayListDisplayPanel.WIDTH + 50;
		action.y = displayPanel.listGraphicsHeight - 100;
		displayPanel.actionQueue.add(action);
		return e;
	}

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices).
	 * 
	 * @param index - the index of the element to be removed
	 * @return the element that was removed from the list
	 * @throws IndexOutOfBoundsException if the index is out of range(index < 0 ||
	 *                                   index >= size())
	 */
	public T remove(int index) throws IndexOutOfBoundsException {
		T e = get(index);
		// Expected list
		T[] nList = (T[]) new Object[expectedList.length - 1];
		for (int i = 0; i < index; i++)
			nList[i] = expectedList[i];
		for (int i = index + 1; i < expectedList.length; i++)
			nList[i - 1] = expectedList[i];
		expectedList = nList;

		// Display list
		Action<T> action = new Action<T>(Action.REMOVE, index, null);
		action.x = 20 + action.index * 50;
		action.y = displayPanel.listGraphicsHeight;
		displayPanel.actionQueue.add(action);
		return e;
	}

	/**
	 * Removes the first occurrence of the specified element from this list, if it
	 * is present. If the list does not contain the element, it is unchanged. More
	 * formally, removes the element with the lowest index i such that (o==null ?
	 * get(i)==null : o.equals(get(i)))(if such an element exists). Returns true if
	 * this list contained the specified element (or equivalently, if this list
	 * changed as a result of the call).
	 * 
	 * @param o - element to be removed from this list, if present
	 * @return true if this list contained the specified element
	 */
	public boolean remove(T o) {
		int index = indexOf(o);
		if (index == -1) {
			return false;
		} else {
			remove(index);
			return true;
		}
	}

	/**
	 * Returns the index of the first occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element. More formally, returns
	 * the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))), or
	 * -1 if there is no such index.
	 * 
	 * @param o - element to search for
	 * @return the index of the first occurrence of the specified element in this
	 *         list, or -1 if this list does not contain the element
	 */
	public int indexOf(T o) {
		for (int i = 0; i < expectedList.length; i++) {
			if (expectedList[i] == o) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Returns the number of elements in this list.
	 * 
	 * @return the number of elements in this list
	 */
	public int size() {
		return expectedList.length;
	}

	/**
	 * Returns true if this list contains the specified element. More formally,
	 * returns true if and only if this list contains at least one element e such
	 * that (o==null ? e==null : o.equals(e)).
	 * 
	 * @param o - element whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 */
	public boolean contains(T o) {
		for (T t : expectedList) {
			if (t.equals(o)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes all of the elements from this list. The list will be empty after this
	 * call returns.
	 */
	public void clear() {
		for(int i = expectedList.length-1; i>=0; i--) {
			remove(i);
		}
		list = (T[]) new Object[0];
		expectedList = (T[]) new Object[0];
	}

	public void draw() {
		// TODO Auto-generated method stub
		displayPanel.repaint();
	}

	private void printExpected() {
		String exList = "";
		for (T t : expectedList) {
			exList += t.toString() + ", ";
		}
		System.out.println(exList.substring(0, exList.length() - 2) + " => Size: " + expectedList.length);
	}
}
