package ThirdTask;



public class StringTest {
    public static void main(String[] args) {

        String str = " ivAnov   iVan ivANnovich";
        StringBuilder capitalizedString = new StringBuilder();
        boolean previousSpace = true;
        for (char c : str.toCharArray()) {
            if (Character.isWhitespace(c)) {

                if (!previousSpace) {
                    capitalizedString.append(' ');
                    previousSpace = true;
                }
            } else {

                if (previousSpace) {
                    capitalizedString.append(Character.toUpperCase(c));
                } else {
                    capitalizedString.append(Character.toLowerCase(c));
                }
                previousSpace = false;
            }
        }
        System.err.println(capitalizedString.toString());

        String str2 = "12+45-10+2";
        int total = 0;
        int number = 0;
        char operation = '+';


        for (int i = 0; i < str2.length(); i++) {
            char currentChar = str2.charAt(i);

            if (Character.isDigit(currentChar)) {
                number = number * 10 + (currentChar - '0');
            }

            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == str2.length() - 1) {
                switch (operation) {
                    case '+':
                        total += number;
                        break;
                    case '-':
                        total -= number;
                        break;
                }
                operation = currentChar;
                number = 0;
            }
        }
        System.err.println(total);











    }
}
