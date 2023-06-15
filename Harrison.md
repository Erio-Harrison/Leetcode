Think1：
Regarding the fourth question, we need to use binary search. What is used here is not the usual dichotomy, 
but the search is carried out by continuously narrowing the interval. 
I haven't fully figured it out yet, it will take time to learn later.

想法二:
10/6/2023：今天写了四道简单的数组题，数组是最简单的数据结构，比较容易。

想法三：
12/6/2023：关于21. Merge Two Sorted Lists和24. Swap Nodes in Pairs很像
目前会两种解法：recursion 和 虚拟头+指针，第二种需要再熟悉熟悉。
12/6/2023:
理解了指针方式：所谓的指针在Java里就是存储在heap里的reference，
我们没有为了存储数据创建新的内存，而只是改变了reference引用的内容。

在 Java 中，对象引用存储在堆栈内存中。 当创建一个新对象时，实际对象存储在heap内存中，并在stack内存中创建对该对象的reference。

所以，当我们写ListNode dummy = new ListNode(-1);时，在堆内存中创建了一个新的ListNode对象，它的reference存放在栈内存中。
变量 dummy 持有这个reference，它指向heap内存中的实际 ListNode 对象。

在 Java 中，所有局部变量及其各自的对象reference都存储在heap内存中，而reference指向的实际对象存储在stack内存中。

想法三：
13/6/2023：
关于19 removeNthFromEnd：注意：point2.next=point2.next.next;
这里是在修改point2.next这个对象的值，而不是在修改reference。

想法四：
Lee328和Lee92结合可以吃透reference 和heap stack的关系：

Node a = new Node(1);
Node b = a;  // b and a are now pointing to the same object in memory

b.val = 2;   // we modify the object itself
System.out.println(a.val); // prints "2", because a and b refer to the same object

Node c = new Node(3);
b = c;       // we change the reference, not modifying the object itself
System.out.println(a.val); // still prints "2", because a is still pointing to the original object
