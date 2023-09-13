------------------------------------------------------------------
数据结构之链表：

想法：
12/6/2023：关于21. Merge Two Sorted Lists和24. Swap Nodes in Pairs很像
目前会两种解法：recursion 和 虚拟头+指针，第二种需要再熟悉熟悉。
12/6/2023:
理解了指针方式：所谓的指针在Java里就是存储在heap里的reference，
我们没有为了存储数据创建新的内存，而只是改变了reference引用的内容。

在 Java 中，对象引用存储在堆栈内存中。 当创建一个新对象时，实际对象存储在heap内存中，并在stack内存中创建对该对象的reference。

所以，当我们写ListNode dummy = new ListNode(-1);时，在堆内存中创建了一个新的ListNode对象，它的reference存放在栈内存中。
变量 dummy 持有这个reference，它指向heap内存中的实际 ListNode 对象。

在 Java 中，所有局部变量及其各自的对象reference都存储在heap内存中，而reference指向的实际对象存储在stack内存中。

想法：
13/6/2023：
关于19 removeNthFromEnd：注意：point2.next=point2.next.next;
这里是在修改point2.next这个对象的值，而不是在修改reference。

想法：
Lee328和Lee92结合可以吃透reference 和heap stack的关系：

案例1：
Node a = new Node(1);
Node b = a;  // b and a are now pointing to the same object in memory

b.val = 2;   // we modify the object itself
System.out.println(a.val); // prints "2", because a and b refer to the same object

Node c = new Node(3);
b = c;       // we change the reference, not modifying the object itself
System.out.println(a.val); // still prints "2", because a is still pointing to the original object

案例2：

ListNode node1 = new ListNode(1);
ListNode node2 = new ListNode(2);

ListNode ref1 = node1;
ListNode ref2 = ref1;

ref1.val = 3;
System.out.println(ref2.val);  // prints "3"

ref1 = node2;
System.out.println(ref1.val);  // prints "2"
System.out.println(ref2.val);  // still prints "3", because ref2 still points to the original node
-----------------------------------------------------------------
双端队列：
Deque表示双端队列。双端队列是在两端都可以进行插入和删除的队列。

常用方法：

新建一个双端队列：Deque<Character> deque = new LinkedList<Character>();
判断是否为空： deque.isEmpty()
增：deque.offerFirst()， deque.offerLast();//从头添加和尾部添加
删：deque.pollFirst()， deque.pollLast()//从头添加和尾部出队
查：deque.peekFirst(), deque.peekLast()//查看头添加和尾部元素

高级用法：

deque.removeFirstOccurrence()
deque.removeLastOccurrence()
分别代表删除第一次出现的该元素和最后一次出现的该元素，返回true则执行成功否则失败。
-----------------------------------------------------------------
长度不可变的滑动窗口：删掉第一个element，加上后一个element

长度可变的滑动窗口：
Lee3：长度可变的滑动窗口，用一个集合来记录没有重复过的符号.
如果遇到之前出现过的符号，集合里去掉除了这个符号及之前的所有符号，继续记录，取集合元素最多的情况。
Lee209:长度可变的滑动窗口，长度是right-left，调整left和right实现滑动(双指针)。
Lee239:用一个双端队列，第一个循环确保了窗口长度（首尾元素索引差为k-1），第二个循环确保了队列的首个元素始终是最大的那个，方便后面加到result里。
由于确保deque第一个元素是最大的，从deque变化情况来看，归纳到长度可变的滑动窗口可能更合适。但从第一个循环来看，属于长度不变。
Lee76:
构造一个Hashmap记录目标字符出现的次数，right索引遍历原始字符串，构造另一个Hashmap用来记录遍历过程中出现的字符。
result数组第一个元素记录最短窗口的长度，第二个记录left索引，第三个记录right索引。
Hashmap的Integer会缓存一系列值，超出此范围的值直接用==有可能结果不一样。比较Integer对象的值，可以用equal，intvalue（）取int值，或者compareTo。
每当满足目标字符的时候（formed==required），更新result，滑动left索引，删掉不必要的字符以获得最小长度。
-----------------------------------------------------------------
树：
Lee95:类似前序遍历。用到了递归的思想，递归至叶子节点情况时，层层返回。
触摸到叶子节点把不同的结果添加到列表，然后来到下一层。到了下一层的时候，需要遍历上一层里子树不同的结果。
比如n=3且3作为根节点的时候，左子树的有“1”子节点和“2”子节点，即n=2的情况，遍历1和2分别作为根节点的情况（前序遍历）。
n=2的不同结果就是n=3左子树的不同结果，再结合右子树，层层递归至最终的根节点。

Lee96:96用的是动态规划，如果给定一个数字n，那么1~n的任何一个数字都可以当成根节点，所以遍历1~n作为根节点的所有情况。
某个数字作为根节点的时候，树的左右两边所具有的情况相乘，就是这个数字作为根节点时，树可能存在的情况。
由于题目给定的条件是从1到n不间断的，所以计算树的左右两边情况时，树的节点数就是某个数字作为根节点时候的情况。
比如1 2 3，2和3作为1的右子节点的时候，等于n=2时树的情况数（2）。我们在遍历1~n时，树的左右两边情况也可以变化。
eg:假如n=4，可以左边0个子节点，右边3个，左边1个，右边2个......
（那么Tree[4] = Tree[0]*Tree[3]+Tree[1]*Tree[2]+Tree[2]*Tree[1]+Tree[3]*Tree[0]）。
用数字记录下来所有情况的可能，在涉及n更大的情况的时候，可以直接调用之前n较小情况的，节约计算时间，也可以用Hashmap来记录。

95和96这两问也都用到了分而治之的思想（左子树和右子树分开遍历然后结合最终的结果）。

Lee110 和Lee111都可以用深度优先搜索；Lee111用广度优先更快（队列）。

------------------------------------------------------------------
在Java中，一切都是按值传递的。 然而，经常引起混淆的区别是原始值和参考值之间的区别。

对于对象（如数组、列表、树等）：

将对象传递给函数时，实际上正在传递对该对象的引用（或者更准确地说，正在传递该引用的副本）。
这意味着对对象内部状态所做的任何更改（例如，修改列表的元素、更改树节点的值等）都将反映在原始对象中，
因为原始引用和复制的引用都指向 相同的内存位置（堆中的相同对象）。
但是，如果将函数内部的引用指向一个新对象（例如，如果为其分配一个新列表或一个新树），则这不会影响函数外部的原始引用。
对于基元（如 int、char、boolean 等）：

传递的是实际值，而不是参考值。 因此，对函数内部参数所做的任何更改都不会影响函数外部的原始值。
将此应用于示例：

对于树节点（root.left=deleteNode(root.left,root.val);）：
deleteNode 方法可能会在内部更改子树的结构。 
但是，如果它返回一个新的子树根（由于删除，这可能是一个不同的节点），则必须使 root.left 引用指向这个新的子树根。 
因此，将返回值分配回 root.left。

对于列表：
如果将列表传递给函数，然后在函数内部修改其元素，这些更改将反映在函数外部的原始列表中，因为函数内部的引用和外部的引用都指向内存中的同一个列表对象。
但是，如果在函数内部将新列表分配给引用（例如，list = new ArrayList<>()），则这不会影响函数外部的原始列表。
-----------------------------------------------------------------
235和236的一个简单思路：
如果p和q在root的两边，那结果就是root。
如果p和q在root的同一边，那只需要不断遍历一边，直到等于p和q当中的一个,或者p和q来到新root的两边。
------------------------------------------------------------------