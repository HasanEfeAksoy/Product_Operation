import java.util.ArrayList;
import java.util.Scanner;


class Entity {
    private int id;
    private String name;
    private double price;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}

class Product extends Entity {
    Product(int id, String name, double price) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
    }
}

class ProductManager {

    ArrayList<Product> products = new ArrayList<Product>();

    public void AddProduct(int id, String name, double price) {
        if (this.products.size() == 0) {
            products.add(new Product(id, name, price));
            System.out.println("* ID'si " + id + " olan urun eklendi.");
        }
        else {
            for (int i = 0; i < this.products.size(); i++) {
                if (this.products.get(i).getId() == id) {
                    System.out.println("* ID'si " + id + " olan bir urun zaten var.");
                    break;
                }
                if (i == this.products.size() - 1) {
                    products.add(new Product(id, name, price));
                    System.out.println("* ID'si " + id + " olan urun eklendi.");
                    break;
                }
            }
        }
    }

    public void RemoveProduct(int id) {
        if (this.products.size() == 0) {
            System.out.println("* ID'si " + id + " olan urun bulunmamakta.");
        }
        else {
            for (int i = 0; i < this.products.size(); i++) {
                if (this.products.get(i).getId() == id) {
                    this.products.remove(i);
                    System.out.println("* ID'si " + id + " olan urun silindi.");
                    break;
                }
                if (i == this.products.size() - 1) {
                    System.out.println("* ID'si " + id + " olan urun bulunmamakta.");
                    break;
                }
            }
        }
    }

    public void ShowProducts() {
        System.out.println("\n\n" + this.products.size() + " adet urun bulunmakta.");
        if (this.products.size() == 0) {
            System.out.println("\n\nHerhangi Bir Urun Bulunmamakta.");
        }
        else {
            System.out.println("\n--------------URUNLER--------------");
            for (int i = 0; i < this.products.size(); i++) {
                System.out.println(i + 1 + ") ID:" + this.products.get(i).getId() + " | NAME:" + this.products.get(i).getName() + " | PRICE:" + this.products.get(i).getPrice());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        ProductManager productManager = new ProductManager();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Urun Eklemek Icın 'e' Tusuna, Urun Silmek Icın 's', Mevcud Urunleri Gormek Icın 'g', Cikmak Icın 'q' Tusuna Basiniz..");
            String EorSorGorQ = scanner.nextLine();
            if (EorSorGorQ.equals("e")) {
                try {
                    System.out.println("\nEklemek istediginiz urunun ID sini giriniz... [ID her urunde farklı olmak zorundadır!]");
                    String _id = scanner.nextLine();
                    System.out.println("\nEklemek istediginiz urunun ADINI giriniz...");
                    String _name = scanner.nextLine();
                    System.out.println("\nEklemek istediginiz urunun FIYATINI giriniz...");
                    String _price = scanner.nextLine();

                    productManager.AddProduct(Integer.parseInt(_id), _name, Double.parseDouble(_price));
                    System.out.println("\n");
                    continue;
                }
                catch (Exception e) {
                    System.out.println("Bir Hata Olustu. Lutfen Bastan Deneyin.");
                    System.out.println("\n");
                    continue;
                }
            }
            else if (EorSorGorQ.equals("s")) {
                try {
                    System.out.println("Silmek istediginiz urunun ID sini giriniz...");
                    String __id = scanner.nextLine();

                    productManager.RemoveProduct(Integer.parseInt(__id));
                    System.out.println("\n");
                    continue;
                }
                catch (Exception e) {
                    System.out.println("Bir Hata Olustu. Lutfen Bastan Deneyin.");
                    System.out.println("\n");
                    continue;
                }
            }
            else if (EorSorGorQ.equals("g")) {
                try {
                    productManager.ShowProducts();
                    System.out.println("\n");
                    continue;
                }
                catch (Exception e) {
                    System.out.println("Bir Hata Olustu. Lutfen Bastan Deneyin.");
                    System.out.println("\n");
                    continue;
                }
            }
            else if (EorSorGorQ.equals("q")) {
                System.out.println("\nCIKIS YAPILIYOR..");
                break;
            }
            else {
                System.out.println("Gecersiz Bir Harfe Bastiniz. Lutfen Tekrar Deneyin.");
                System.out.println("\n");
                continue;
            }
        }

    }
}
