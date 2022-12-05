import java.util.Scanner;
import java.util.regex.*;
public class JJ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите пароль: ");
        String pass = in.nextLine();
        Pattern safeX = Pattern.compile("[A-Z]");
        Matcher x = safeX.matcher(pass);
        Pattern safeY = Pattern.compile("[a-z]");
        Matcher y = safeY.matcher(pass);
        Pattern safeZ = Pattern.compile("[0-9]");
        Matcher z = safeZ.matcher(pass);
        Pattern only = Pattern.compile("[^a-zA-Z0-9_]+");
        Matcher use;
        do{
            while(x.find() == false || y.find() == false || z.find() == false){
                System.out.println("Чтобы пароль был безопасным обязательно дожен содержать заглавную, маленькую и цифру");
                System.out.print("Повторите попытку: ");
                pass = in.nextLine();
                x = safeX.matcher(pass);
                y = safeY.matcher(pass);
                z = safeZ.matcher(pass);
            }
            use = only.matcher(pass);
            while(use.find() == true){
                System.out.println("Можно использовать только цифры, английские буквы и знак подчеркивания");
                System.out.print("Повторите ввод: ");
                pass = in.nextLine();
                use = only.matcher(pass);
            }
            while(pass.length() < 8 ){
                System.out.println("Пароль дожен сожержать минимум 8 символов");
                System.out.print("Повторите попытку: ");
                pass = in.nextLine();
            }
            use = only.matcher(pass);
            x = safeX.matcher(pass);
            y = safeY.matcher(pass);
            z = safeZ.matcher(pass);
        } while (x.find() == false || y.find() == false || z.find() == false || use.find() == true);
        System.out.println();
        System.out.println("Ваш пароль надёжен");
    }
}