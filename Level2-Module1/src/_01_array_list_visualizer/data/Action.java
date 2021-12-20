package _01_array_list_visualizer.data;

public class Action<T> {
	public static final int ADD = 0;
	public static final int INSERT = 1;
	public static final int SET = 2;
	public static final int REMOVE = 3;
	int type;
	int index;
	T value;
	
	int x;
	int y;
	Action(int type, int index, T value){
		this.type = type;
		this.index = index;
		this.value = value;
	}
}
