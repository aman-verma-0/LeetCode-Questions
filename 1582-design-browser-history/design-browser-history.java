class ListNode{
    String url;
    ListNode next;
    ListNode prev;
    ListNode(String st){
        this.url=st;
        this.next=null;
        this.prev=null;
    }
}
class BrowserHistory {
    
    // ListNode head;
    ListNode curPage;

    public BrowserHistory(String homepage) {
        
        this.curPage=new ListNode(homepage);
    }
    
    public void visit(String url) {
        ListNode nn=new ListNode(url);
        curPage.next=nn;
        nn.prev=curPage;
        curPage=nn;    
    }
    
    public String back(int steps) {
        // ListNode temp=curPage;
        while(curPage.prev!=null && steps>0){
            curPage=curPage.prev;
            steps--;
        }
        return curPage.url;
        
    }
    
    public String forward(int steps) {
        //ListNode temp=curPage;
        while(curPage.next!=null && steps>0){
            curPage=curPage.next;
            steps--;
        }
        return curPage.url;
        
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */