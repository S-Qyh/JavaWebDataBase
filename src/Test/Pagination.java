package Test;
/*
分页对象
 */
public class Pagination {

    private int pageNo = 1; //当前页码
    private int pageCount = 0; //总页数
    private int pageSize = 12; //每页显示记录数
    private int countSize = 0; //总记录条数

    private String pageBar;
    private String numPageBar;
    private String url;

    public String getPageBar() {
        pageCount = getPageCount();

        if (pageCount != 0) {
            //判断当前页号的合法性
            if (pageNo < 1) {
                pageNo = 1;
            }
            if (pageNo > pageCount) {
                pageNo = pageCount;
            }

            StringBuilder sb = new StringBuilder();
            sb.append("每页：").append(pageSize).append("&nbsp;&nbsp;页次：").append(pageNo).
                    append("/").append(pageCount).append("&nbsp;&nbsp;总计：").append(countSize).
                    append("&nbsp;");
            if (pageNo != 1) {
                sb.append("<a href=\"").append(url).append("?pageNo=").append("1\">首页</a> ");
                sb.append("<a href=\"").append(url).append("?pageNo=").append(pageNo - 1).append("\">上页</a> ");
            }

            if (pageNo != pageCount) {
                sb.append("<a href=\"").append(url).append("?pageNo=").append(pageNo + 1).append("\">下页</a> ");
                sb.append("<a href=\"").append(url).append("?pageNo=").append(pageCount).append("\">尾页</a> ");
            }
            pageBar = sb.toString();
        } else {
            pageBar = "";
        }
        return pageBar;
    }

    public void setPageBar(String pageBar) {
        this.pageBar = pageBar;
    }

    public String getNumPageBar() {
        pageCount = getPageCount();

        if (pageCount != 0) {
            //判断当前页号的合法性
            if (pageNo < 1) {
                pageNo = 1;
            }
            if (pageNo > pageCount) {
                pageNo = pageCount;
            }
            StringBuilder sb = new StringBuilder();
            //计算当前页所在的组
            int group = pageNo / 5 + (pageNo % 5 == 0 ? 0 : 1);
            int start = (group - 1) * 5 + 1;
            int end = start + 4;
            System.out.println("group:" + group + ";start:" + start + ";end:" + end);
            if (end > pageCount) {
                end = pageCount;
            }

            if (start > 1) {
                sb.append("<a href=\"").append(url).append("?pageNo=").
                        append(start - 1).append("\">&lt;</a> ");
            }
            for (int i = start; i <= end; i++) {
                if (pageNo != i) {
                    sb.append("<a href=\"").append("?pageNo=").append(i).
                            append("\">").append(i).append("</a> ");
                } else {
                    sb.append("<a href=\"#\">").append(i).append("</a> ");
                }
            }
            if (end < pageCount) {
                sb.append("<a href=\"").append("?pageNo=").append(end + 1).append("\">&gt;</a>");
            }
            numPageBar = sb.toString();
        } else {
            numPageBar = "";
        }
        return numPageBar;
    }

    public void setNumPageBar(String numPageBar) {
        this.numPageBar = numPageBar;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageCount() {
        if (countSize != 0) {
            if (countSize % pageSize != 0) {
                pageCount = countSize / pageSize + 1;
            } else {
                pageCount = countSize / pageSize;
            } }
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCountSize() {
        return countSize;
    }

    public void setCountSize(int countSize) {
        this.countSize = countSize;
    }
}
