
package shopping;

import java.util.HashMap;
import java.util.Map;
import product.productDTO;


public class Cart {
    private Map<String, productDTO> cart;

    public Cart() {
    }

    public Cart(Map<String, productDTO> cart) {
        this.cart = cart;
    }

    public Map<String, productDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, productDTO> cart) {
        this.cart = cart;
    }
    public void add(productDTO pro){
        if(this.cart == null){
            this.cart = new HashMap<>();
        }
        if(this.cart.containsKey(pro.getProID())){
            int currentQuantity = this.cart.get(pro.getProID()).getQuantity();
            pro.setQuantity(currentQuantity+ pro.getQuantity());
        }
        cart.put(pro.getProID(), pro);
    }
    public void delete(String id){
        if(this.cart == null){
            return;
        }
        if(this.cart.containsKey(id)){
            this.cart.remove(id);
        }
    }
    
    public void update(String id, productDTO newPro){
        if(this.cart == null){
            return;
        }
        if(this.cart.containsKey(id)){
            this.cart.replace(id, newPro);
        }
    }

   
    
}
