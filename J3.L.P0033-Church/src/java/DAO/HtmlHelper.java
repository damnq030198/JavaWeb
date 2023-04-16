/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author sonnhhe130366
 */
public class HtmlHelper {

    public static String hyperLink(String text, String url) {
        return "<a class=\"paging_link\" href=\"" + url + "\">" + text + "</a>";
    }

    public static String label(String text) {
        return "<span class=\"paging_label\">" + text + "</span>";
    }

    public static String pager(int pageindex, int gap, int totalpage) {
        String result = "";
        if (pageindex - gap > 1) {
            result += hyperLink("First", "?page=1");
        }
        for (int i = gap; i > 0; i--) {
            int page = (pageindex - i);
            if (page > 0) {
                result += hyperLink(page + "", "?page=" + page);
            }
        }

        result += label("" + pageindex);
        for (int i = 1; i <= gap; i++) {
            int page = pageindex + i;
            if (page < totalpage) {
                result += hyperLink(page + "", "?page=" + page);
            }
        }
        if (pageindex + gap < (totalpage -1)) {
            result += hyperLink("Last", "?page=" + (totalpage -1));
        }
        return result;
    }
}
