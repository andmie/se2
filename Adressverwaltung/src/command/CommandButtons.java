package command;

public class CommandButtons {
	private Command[] Button;
	
	private volatile static CommandButtons instance;
	
	public static CommandButtons getInstance(){
		if (instance == null){
			synchronized(CommandButtons.class){
				if (instance == null){
					instance = new CommandButtons(3);
				}
			}
		}
		return instance;
	}
	
	private CommandButtons(int anz){
		Button = new Command[anz];
		
		Command emptyCommand = new emptyCommand();	
		for(int i = 0; i < anz; i++){
			Button[i] = emptyCommand;
		}
		
	}
	
	public void setCommand(int pos, Command command){
		Button[pos] = command;
	}
	
	public void pressButton(int pos){
		//FŸge Aktion in history ein
		InvokeHistory.getInstance().push(Button[pos]);
		//System.out.println(InvokeHistory.getInstance().toString());
		Button[pos].execute();
	}
	
	public void undo(){
		Command undo = InvokeHistory.getInstance().pop();
		if(undo != null){
			undo.undo();
		}
		else{
			System.out.println("Nichts mehr rŸckgŠngig machbar!");
		}
	}
}
