package com.hupo.leetcode;

import java.util.*;

public class AccountsMerge {


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
