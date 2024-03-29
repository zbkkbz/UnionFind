/**
 * @author ZBK
 * @date 2019/7/31 - 0:26
 */

/**
 * @program: UnionFind6 路径压缩 by 递归
 *
 * @description:
 *
 * @author: Zbk
 *
 * @create: 2019-07-31 00:26
 **/
public class UnionFind6 implements UF {
    //实际上,parent[i]表示第i个元素指向哪个节点
    private int[] parent;

    //rank[i]表示以i为根的集合所表示树的层数
    private int[] rank;

    public UnionFind6(int size) {
        //初始并查集并没有连接的实现
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++){
            parent[i] = i;
        rank[i] = 1;
        }
    }

    @Override
    public int getSize(){
        return parent.length;
    }

    // 我们在循环中，不断地进行 p = parent[p]，就是不断地让p等于当前的p的父亲节点。
    //这个循环什么时候终止？当p没有父亲节点的时候。此时，p就是根节点。
    //p什么时候没有父亲节点了？就是p == parent[p]的时候，即p的父亲节点就是自己。
    // 因为，我们初始化的时候是这么定义的。
    // 我们队parent数组的初始化，是parent[i]=i，即初始的时候，每个节点都是根节点，每一个节点的parent都指向自己：）
    //因此时间复杂度是O(h)
    private int find(int p){
        if (p<0||p>=parent.length)
            throw new IllegalArgumentException("p is out of bound");

        if (p!=parent[p])
            parent[p] = find(parent[p]);
        return parent[p];
    }

    //查看元素p,q是否属于同一集合,
    //因为使用find方法,所以此方法时间复杂度也是O(h)
    @Override
    public boolean isConnected(int p,int q){
        return find(p)==find(q);

    }

    //O(h)复杂度,h树的高度
    @Override
    public void unionElements(int p,int q){
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot==qRoot)
            return;

        //根据两个元素所在树的rank的不同判断合并方向
        //将rank低的集合合并到rank高的树上
        if (rank[pRoot]< rank[qRoot]) {
            //如果本身pRoot和qRoot不相等,我们就让p的根节点指向q的根节点
            parent[pRoot] = qRoot;
            //不需要维护rank,因为既然rank[pRoot]<rank[qRoot],也就是p所在树的高度小于q所在树的高度
            //那么让p树的根指向q树的根后,q树的高度是没有变化的,
        }
        else if (rank[pRoot] > rank[qRoot]){
            parent[qRoot]=pRoot;
            //不维护rank,同理如上
        }
        else{
            parent[qRoot] = pRoot;
            //这个时候,说明两棵树高度相同,那一颗指向另一颗后,那么高度肯定是要+1的
            rank[pRoot] += 1;
        }
    }

}
