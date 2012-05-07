package command;

import java.util.ArrayDeque;
import java.util.Deque;

import model.IAddressList;

public class InvokeHistory {

	private Deque<Command> commandHistory = null;
	private static volatile InvokeHistory instance = null;
	
	private InvokeHistory() {
		commandHistory = new ArrayDeque<Command>();
	}

	public static InvokeHistory getInstance() {
        if (instance == null) {
        	synchronized(IAddressList.class){
        		if (instance == null) {
        			instance = new InvokeHistory();
        		}
        	}
        }
        return instance;
    }
	
	public boolean isEmpty() {
		return commandHistory.isEmpty();
	}

	public Command peek() {
		return commandHistory.peek();
	}

	public void clear() {
		commandHistory.clear();
	}

	public void push(Command e) {
		commandHistory.push(e);
		System.out.println(commandHistory.toString());
	}

	public Command pop() {
		if (!isEmpty()){
			System.out.println(commandHistory.toString());
			return commandHistory.pop();
		}
		else return null;
	}

	public int size() {
		return commandHistory.size();
	}

}
