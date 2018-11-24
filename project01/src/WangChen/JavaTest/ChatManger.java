package WangChen.JavaTest;

import java.util.Vector;

public class ChatManger {
    private ChatManger(){}
    private static  final ChatManger cm = new ChatManger();
    public static ChatManger getChatManger(){
        return cm;
    }

    Vector<ChatSocket> vector = new Vector<ChatSocket>();
    public void add(ChatSocket cs){
        vector.add(cs);
    }

    public  void publish(ChatSocket cs,String out){
        for (int i = 0; i < vector.size(); i++) {
            ChatSocket csChatScoket = vector.get(i);
            if(!cs.equals(csChatScoket)){
                csChatScoket.out(out);
            }
        }
    }

}
