package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        // corner case
        if (path == null || path.length() == 0) return null;
        Stack<String> stack = new Stack<>();
        String[] arr = path.split("/");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!arr[i].equals("..") && !arr[i].equals(".") && !arr[i].equals("")) {
                stack.push(arr[i]);
            }
        }
        List<String> list = new ArrayList<>(stack); // from bottom to top
        return "/" + String.join("/", stack);
    }
}
