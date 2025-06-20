import java.util.*;

class Product {
    int id;
    String name, cat;

    Product(int id, String name, String cat) {
        this.id = id;
        this.name = name;
        this.cat = cat;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Category: " + cat;
    }
}

public class EcomApp {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product(101, "Smartphone", "Electronics"));
        list.add(new Product(102, "Sneakers", "Footwear"));
        list.add(new Product(103, "Backpack", "Fashion"));
        list.add(new Product(104, "Wireless Mouse", "Electronics"));
        list.add(new Product(105, "Denim Jacket", "Apparel"));

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product Name to Search: ");
        String pname = sc.nextLine();

        // Linear Search
        Product res1 = linearSearchByName(list, pname);
        printResult(res1, "Linear");

        // Sort for Binary Search
        list.sort(Comparator.comparing(p -> p.name));
        Product res2 = binarySearchByName(list, pname);
        printResult(res2, "Binary");
    }

    static Product linearSearchByName(List<Product> list, String name) {
        for (Product p : list) {
            if (p.name.equalsIgnoreCase(name)) return p;
        }
        return null;
    }

    static Product binarySearchByName(List<Product> list, String name) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int cmp = name.compareToIgnoreCase(list.get(m).name);
            if (cmp == 0) return list.get(m);
            else if (cmp > 0) l = m + 1;
            else r = m - 1;
        }
        return null;
    }

    static void printResult(Product p, String method) {
        if (p != null) {
            System.out.println("Found using " + method + " Search: " + p);
        } else {
            System.out.println("Not found using " + method + " Search.");
        }
    }
}
