package _01_array_list_visualizer.data;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JPanel;

public class ArrayListDisplayPanel<T> extends JPanel {
	static final int WIDTH = 500;
	static final int HEIGHT = 300;
	int listGraphicsHeight = 200;
	ArrayList<T> list;
	Queue<Action<T>> actionQueue;
	Action<T> currentAction = null;
	int lastActionIndex = -1;
	
	ArrayListDisplayPanel(ArrayList<T> list){
		this.list = list;
		actionQueue = (Queue<Action<T>>) new LinkedList<Action<T>>();
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		drawList(g);
		if (currentAction != null) {
			if (currentAction.type == Action.ADD) {
				addAnimation(g, currentAction);
			} else if (currentAction.type == Action.INSERT) {
				if (checkIndexOutOfBounds(currentAction.index)) {
					return;
				}
				insertAnimation(g, currentAction);
			} else if (currentAction.type == Action.SET) {
				if (checkIndexOutOfBounds(currentAction.index)) {
					return;
				}
				setAnimation(g, currentAction);
			} else if (currentAction.type == Action.REMOVE) {
				if (checkIndexOutOfBounds(currentAction.index)) {
					return;
				}
				removeAnimation(g, currentAction);
			}
		} else {
			if (actionQueue.size() > 0) {
				currentAction = actionQueue.remove();
				if (currentAction.type == Action.REMOVE) {
					currentAction.value = list.list[currentAction.index];
				}
			}
		}
	}
	
	boolean checkIndexOutOfBounds(int index) {
		if (index >= list.list.length || index < 0) {
			currentAction = null;
			return true;
		}
		return false;
	}
	
	void drawList(Graphics g) {
		for (int i = 0; i < list.list.length; i++) {
			Color c = Color.cyan;
			if (i == lastActionIndex) {
				c = Color.green;
			}
			drawObjectAt(g, c, list.list[i], i, 20 + i * 50, listGraphicsHeight);
		}
	}
	
	private void drawObjectAt(Graphics g, Color c, Object item, int index, int x, int y) {
		int xOffset = 4 * item.toString().length();
		g.setColor(c);
		g.fillRect(x, y, 50, 50);
		g.setColor(Color.RED);
		g.drawRect(x, y, 50, 50);
		g.setColor(Color.BLACK);
		g.drawString(item + "", x + 25 - xOffset, y + 20);
		g.drawString(index + "", x + 20, y + 35);
	}

	private void drawBlankObjectAt(Graphics g, Color c, int x, int y) {
		g.setColor(c);
		g.fillRect(x, y, 50, 50);
		g.setColor(Color.RED);
		g.drawRect(x, y, 50, 50);
	}
	
	private void addAnimation(Graphics g, Action<T> action) {
		if (action.x > 20 + list.list.length * 50) {
			action.x -= 4;
		} else {
			addAction(action);
			endCurrentAction(action);
		}
		drawObjectAt(g, Color.green, action.value, list.list.length, action.x, action.y);
	}
	
	private void addAction(Action<T> action) {
		T[] tList = (T[]) new Object[list.list.length + 1];
		for (int i = 0; i < list.list.length; i++) {
			tList[i] = list.list[i];
		}
		tList[list.list.length] = action.value;
		list.list = tList;
	}
	
	private void insertAnimation(Graphics g, Action<T> action) {
		if (action.x > 20 + action.index * 50) {
			action.x -= 4;
		} else if (action.y < listGraphicsHeight) {
			action.y += 2;
			drawBlankObjectAt(g, Color.gray, 20 + action.index * 50, listGraphicsHeight);
			if (!list.list[action.index].equals("")) {
				insertAction(new Action(Action.INSERT, action.index, ""));
			}
		} else {
			setAction(action);
			endCurrentAction(action);
		}
		drawObjectAt(g, Color.green, action.value, action.index, action.x, action.y);
	}

	private void insertAction(Action<T> action) {
		if (action.index < 0 || action.index > list.list.length - 1)
			throw new IndexOutOfBoundsException();

		T[] tList = (T[]) new Object[list.list.length + 1];

		int ctr = 0;

		for (int i = 0; i < tList.length; i++) {
			if (i == action.index) {
				tList[i] = action.value;
			} else {
				tList[i] = list.list[ctr++];
			}
		}
		list.list = tList;
	}
	
	private void setAnimation(Graphics g, Action<T> action) {
		if (action.x > 20 + action.index * 50) {
			action.x -= 4;
		} else if (action.y < listGraphicsHeight) {
			action.y += 2;
			drawBlankObjectAt(g, Color.gray, 20 + action.index * 50, listGraphicsHeight);
		} else {
			setAction(action);
			endCurrentAction(action);
		}
		drawObjectAt(g, Color.green, action.value, action.index, action.x, action.y);
	}

	private void setAction(Action<T> action) {
		if (action.index < 0 || action.index > list.list.length)
			throw new IndexOutOfBoundsException();

		for (int i = 0; i < list.list.length; i++) {
			if (i == action.index) {
				list.list[i] = action.value;
				break;
			}
		}
	}
	
	private void removeAnimation(Graphics g, Action<T> action) {
		if (action.y < HEIGHT) {
			action.y += 2;
			drawBlankObjectAt(g, Color.gray, 20 + action.index * 50, listGraphicsHeight);
		} else {
			removeAction(action);
			endCurrentAction(new Action<T>(Action.REMOVE, -1, null));
		}
		drawObjectAt(g, Color.green, action.value, list.list.length, action.x, action.y);
	}

	private void removeAction(Action<T> action) {
		if (action.index < 0 || action.index > list.list.length)
			throw new IndexOutOfBoundsException();

		int ctr = 0;
		T[] tList = (T[]) new Object[list.list.length - 1];
		for (int i = 0; i < list.list.length; i++) {
			if (i != action.index) {
				tList[ctr++] = list.list[i];
			}
		}

		list.list = tList;
	}
	
	private void endCurrentAction(Action<T> action) {
		currentAction = null;
		lastActionIndex = action.index;
	}

}
