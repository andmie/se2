import view.AddressListView;
import model.BeanFactory;

public class Starter {
 public static void main(String[] args) {
	 BeanFactory.getAddressListBean().subscribe(new AddressListView());
 }
}

