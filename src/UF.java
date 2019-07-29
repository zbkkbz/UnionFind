/**
 * @author ZBK
 * @date 2019/7/29 - 23:34
 */
public interface UF {
    //查:两个元素是否可以连接
    //传进来2个int型,我们下节介绍,对于传来的元素是谁,我们并不关心
    //使用并查集的时候,可以将元素和一个数组对应的数组的索引做映射
    //真正关心的是id为p和id为q的这两个元素是否相连
    //对于p,q真正对应的元素是多少,我们并不关心
    boolean isConnected(int p, int q);

    void unionElements(int p,int q);

    //跟线段树相似,我们在并查集这并不考虑添加或者删除一个元素
    //对于并查集来说,对于当下固定的元素来说,我们进行并和查.
    int getSize();

}
