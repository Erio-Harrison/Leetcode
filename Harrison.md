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