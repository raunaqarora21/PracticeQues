public class Practice_1 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        StringBuilder sb1 = new StringBuilder();
        String s = "Hello";
        String sub = s.substring(2);
        System.out.println(sub);
        System.out.println("Length of string "+s+" is "+s.length());
        //System.out.println("Capacity of string"+);

        sb.append('H');
        sb1.append(1);
        sb.append(sb1);
        /*System.out.println("Capacity:"+sb.capacity());
        System.out.println(sb);
        System.out.println(sb1);



         */
        String a="";
        String b="";
        String c = "amar";
        String d = "rama";
        for(char i='a';i<='z';i++){
            for(int j=0;j<c.length();j++){
                char ch = c.charAt(j);
                char ch1 = d.charAt(j);
                if(ch == i) a+=ch;
                if(ch1 == i) b+=ch1;


            }



        }


        if(a.compareTo(b) == 0) System.out.println("Both contains same characters");
        else System.out.println("Both characters are not same ");




    }

}
