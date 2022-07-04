package Acount;

import java.io.Serializable;

public class UserGuest implements Serializable {
        private int id ;
        private String user;
        private String pass;

        private static int count = 0;

        public UserGuest(String user, String pass) {
                id = ++count;
                this.user = user;
                this.pass = pass;
        }

        public UserGuest(int id, String user, String pass) {
                this.id = id;
                this.user = user;
                this.pass = pass;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public static int getCount() {
                return count;
        }

        public static void setCount(int count) {
                UserGuest.count = count;
        }

        public String getUser() {
                return user;
        }

        public void setUser(String user) {
                this.user = user;
        }

        public String getPass() {
                return pass;
        }

        public void setPass(String pass) {
                this.pass = pass;
        }

        @Override
        public String toString() {
                return "UserGuest{" +
                        "id='" + id + '\'' +
                        ", user='" + user + '\'' +
                        ", pass='" + pass + '\'' +
                        '}';
        }
}
