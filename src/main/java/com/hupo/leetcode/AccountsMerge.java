package com.hupo.leetcode;

import java.util.*;

public class AccountsMerge {

    public static void main(String[] args) {
        int[] array = new int[]{1,100,1,1,1,100,1,1,100,1};
        int result = minStep(array);
        System.out.println(result);

    }

    public static int minStep(int[] re) {
        if (re == null || re.length == 0) {
            return 0;
        }
        if (re.length == 1) {
            return re[0];
        }
        int result[] = new int[re.length + 1];
        int length = re.length;
        result[re.length - 1] = re[re.length - 1];

        for (int i = re.length - 2; i >= 0; i--) {
            int one = re[i] + result[i + 1];
            int two = re[i] + result[i + 2];

            result[i] = Math.min(one, two);
        }
        return Math.min(result[0], result[1]);
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else { // nums[mid] > target
                right = mid;
            }
        }
        // 未找到目标值
        return -1;
    }


    public long maxScore(int[] nums, int x) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i <= nums.length - 1; i++) {
            result[i] = result[0] + nums[i] - (isSame(nums[0], nums[i]) ? 0 : x);
            for (int j = i - 1; j >= 0; j--) {
                result[i] = Math.max(result[i], result[j] + nums[i] - (isSame(nums[j], nums[i]) ? 0 : x));
            }
        }

        int max = result[0];
        for (int i = 0; i <= result.length - 1; i++) {
            max = Math.max(max, result[i]);
        }
        return max;
    }

    private boolean isSame(int x, int y) {
        return ((x ^ y) & 1) == 0;
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int max = rob(root.left) + rob(root.right);

        int current = (root.val);
        if (root.left != null) {
            current = current + rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            current = current + rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(max, current);
    }

    public int rob(TreeNode root, int flag) {
        if (root == null) {
            return 0;
        }
        if (flag == 1) {
            return root.val + rob(root.left, 0) + rob(root.right, 0);
        } else {
            return rob(root.left, 1) + rob(root.right, 1);
        }
    }


    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            if (stack.isEmpty() || stack.peek().val >= current.val) {
                stack.push(current);
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek().val < current.val) {
                        ListNode top = stack.pop();
                        top.next = null;
                    } else {
                        break;
                    }
                }
                stack.push(current);

            }
            current = current.next;
        }

        ListNode next = null;
        ListNode newHead = null;
        while (!stack.isEmpty()) {
            ListNode top = stack.pop();
            newHead = top;
            top.next = next;
            next = top;
        }
        return newHead;
    }


    public static class Account {
        public String name;
        public Set<String> mails;

        public Account(String name, Set<String> mails) {
            this.name = name;
            this.mails = mails;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashSet<String> names = new HashSet<>();
        Map<String, Account> map = new HashMap<>();
        HashSet<Account> accountList = new HashSet<>();
        for (int i = 0; i <= accounts.size() - 1; i++) {
            String name = accounts.get(i).get(0);
            Set<String> mails = new HashSet<>(accounts.get(i).subList(1, accounts.get(i).size()));

            if (!names.contains(name)) {
                names.add(name);
                Account account = new Account(name, mails);
                accountList.add(account);
                for (String mail : mails) {
                    map.put(mail, account);
                }
            } else {
                HashSet<Account> findAccount = new HashSet<>();
                for (String mail : mails) {
                    if (map.containsKey(mail)) {
                        findAccount.add(map.get(mail));
                    }
                }
                if (findAccount == null || findAccount.isEmpty()) {
                    Account account = new Account(name, mails);
                    accountList.add(account);
                    for (String mail : mails) {
                        map.put(mail, account);
                    }
                } else {
                    mergeAccount(findAccount, accountList, map, mails);
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Account account : accountList) {
            List<String> temp = new ArrayList<>();
            temp.add(account.name);
            List<String> tempMail = new ArrayList<>(account.mails);
            tempMail.sort(String.CASE_INSENSITIVE_ORDER);
            temp.addAll(tempMail);
            result.add(temp);
        }

        return result;
    }


    private void mergeAccount(HashSet<Account> findAccount, HashSet<Account> accountList, Map<String, Account> map, Set<String> mails) {

        if (findAccount == null || findAccount.isEmpty()) {
            return;
        }
        Account[] findList = findAccount.toArray(new Account[findAccount.size()]);
        if (findList.length == 1) {
            for (String mail : mails) {
                findList[0].mails.add(mail);
                map.put(mail, findList[0]);
            }
        } else {

            HashSet<String> hashSet = new HashSet();
            Account account = new Account(findList[0].name, hashSet);
            for (int i = 0; i <= findList.length - 1; i++) {
                accountList.remove(findList[i]);

                for (String mail : findList[i].mails) {
                    hashSet.add(mail);
                    map.put(mail, account);
                }
            }

            for (String mail : mails) {
                hashSet.add(mail);
                map.put(mail, account);
            }

            accountList.add(account);
        }

    }
}
