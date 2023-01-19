public class Main2 {


    public static void main(String[] args) {

        String price = "# 250$";
        //int price2 = Integer.parseInt(price.split("(?<$)")[0]);
        int realPrice = Integer.parseInt(price.replaceAll("\\D+", ""));
        //System.out.println(realPrice);

        //src code -> kompajl -file.class ----> runtime - jvm 010101001 ---

        try {
            Main.ispis();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        int array[] = {1,2};
        try {
            System.out.println(array[3]);
        }catch (Exception e){
            e.printStackTrace();
        }



        System.out.println("Ispis koji zelim da vidim");


    }



}
