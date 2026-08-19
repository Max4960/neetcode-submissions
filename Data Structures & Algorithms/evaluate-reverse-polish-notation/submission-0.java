class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> values = new Stack<>();
        Integer num1;
        Integer num2;
        Integer val;

        for (String token : tokens) {
            switch (token) {
                case "+":
                    num1 = values.pop();
                    num2 = values.pop();

                    values.push(num1 + num2);
                    break;
                case "-":
                    num1 = values.pop();
                    num2 = values.pop();

                    values.push(num2 - num1);
                    break;
                case "*":
                    num1 = values.pop();
                    num2 = values.pop();

                    values.push(num1 * num2);
                    break;
                case "/":
                    num1 = values.pop();
                    num2 = values.pop();

                    values.push(num2 / num1);
                    break;
                default: 
                    val = Integer.parseInt(token);
                    values.push(val);
                    break;
            }
        }
        return values.peek();
    }
}
