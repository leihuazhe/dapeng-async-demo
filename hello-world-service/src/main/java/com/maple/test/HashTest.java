package com.maple.test;

/**
 * @author maple 2018.09.13 上午11:47
 */
public class HashTest {

    public static class SkuKey {
        private String category;
        private String skuProperties;

        public SkuKey(String category, String skuProperties) {
            this.category = category;
            this.skuProperties = skuProperties;
        }


        @Override
        public int hashCode() {
            return this.category.hashCode() + this.skuProperties.hashCode();
        }
    }


    public static class Sku {
        String category;
        String skuProperties;
        String name;

        public Sku(String category, String skuProperties, String name) {
            this.category = category;
            this.skuProperties = skuProperties;
            this.name = name;
        }
    }

    /**
     * main String[] args
     */
    public static void main(String[] args) {
        int hash = hash(new SkuKey("0001", "1:1;2:2;3:3"));
        int hash2 = hash(new SkuKey("0002", "1:1;2:2;3:3"));
        int hash3 = hash(new SkuKey("0003", "1:1;2:2;3:3"));

        int hash4 = hash(new SkuKey("0001", "1:1;2:2;3:3"));
        int hash5 = hash(new SkuKey("0002", "1:1;2:2;3:3"));
        int hash6 = hash(new SkuKey("0003", "1:1;2:2;3:3"));

        System.out.println(hash);
        System.out.println(hash2);
        System.out.println(hash3);
        System.out.println(hash4);
        System.out.println(hash5);
        System.out.println(hash6);
    }

    /**
     * hash()
     */
    private static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
