public class Solution {
    public static String getOrder(String input) {
        //https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#matches(java.lang.String) 
        String[] menuItems = new String[]{"Burger", "Fries", "Chicken", "Pizza", "Sandwich", "Onionrings", "Milkshake", "Coke"};
        
        int wordLen,
            subStrIndex= 0;
        
        String order= "",
               subStr= "";
        
        for(int i= 0; i< menuItems.length; i++){
            subStr= menuItems[i].toLowerCase();
            subStrIndex= 0;
            wordLen= subStr.length();
        
            while(input.indexOf(subStr,subStrIndex) != -1){
                order= order.concat(menuItems[i]).concat(" ");
                subStrIndex = input.indexOf(subStr,subStrIndex) + wordLen;
            }  
        }
        return order.trim();
    }
}
