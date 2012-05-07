import model.spring.AddressList;
import view.AddressListView;

public class Starter {
 public static void main(String[] args) {
	 AddressList.getInstance().subscribe(new AddressListView());
 }
}

