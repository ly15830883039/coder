package rui.coder.algorithms.spike;

import java.util.Comparator;
import java.util.Date;

public  class Rank implements Comparator {
        String userId;
        int num;
        int ranking;
        Date date;

        @Override
        public String toString() {
            return "Rank{" +
                    "userId='" + userId + '\'' +
                    ", num=" + num +
                    ", ranking=" + ranking +
                    ", date=" + date.getTime() +
                    '}';
        }

        public Rank() {
        }

        public Rank(String userId, int num, Date date) {
            this.userId = userId;
            this.num = num;
            this.date = date;
        }

        @Override
        public int compare(Object o1, Object o2) {
            Rank rank1 = (Rank) o1;
            Rank rank2 = (Rank) o2;

            int num = rank1.num - rank2.num;


            Date date1 = rank1.date;
            Date date2 = rank2.date;

            if (num == 0) {
                return (int) (date2.getTime() - date1.getTime());
            }
            return num;
        }
    }