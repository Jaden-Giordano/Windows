package io.jadengiordano.windows;

/**
 * Created by Jaden on 12/5/2015.
 */
public class Inventory {

    private Item[] items;

    public Inventory(int size) {
        this.items = new Item[size];
    }

    public Item getItem(Class<? extends Item> c) {
        for (Item i : items) {
            if (c.isInstance(i)) {
                return i;
            }
        }
        return null;
    }

    public Item getItem(int id) {
        for (Item i : items) {
            if (i.getID() == id)
                return i;
        }
        return null;
    }

    public Item getItemByIndex(int i) {
        return this.items[i];
    }

    public boolean addItem(Item item) {
        boolean added = false;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null) {
                System.out.println("Adding Item " + item.getID() + " at " + i);
                this.items[i] = item;
                added = true;
                break;
            }
        }
        return added;
    }

    public void removeItem(int id) {
        for (Item i : this.items) {
            if (i.getID() == id) {
                i = null;
            }
        }
    }

    public void removeItem(Class<? extends Item> c) {
        for (Item i : items) {
            if (c.isInstance(i)) {
                i = null;
            }
        }
    }

    public int size() {
        return this.items.length;
    }

}
