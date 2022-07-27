The first class is implemented using a regular array.
The second class is implemented using a linked list.
Methods are implemented in both classes :

enqueue, dequeue, get_head, get_size, is_empty, clear, get_peek

* Method enqueue – adds an item to the queue. 

* Method dequeue – deletes and return the first element in the queue. 

* Method get_head - returns the head of the queue.

* Method get_size - returns the size of the queue. 

* Method is_empty - returns true if the queue is empty.

* Method clear - clears the queue. 

* Method get_peek - returns the tail of the queue.

the advantage of the first implementation
1. The access operation to the element occurs in Θ(1)
2. The amount of memory consumed is less, since we do not have to store pointers

disadvantages of the first implementation

1. The operation of inserting and deleting an element has asymptotic complexity Θ(n)

the advantage of the second implementation

1. The operation of accessing the oldest element occurs in Θ(1);
2. The element is added in Θ(1);
3. The code is simple and was written quickly

disadvantages of the second implementation

1. Если нам нужен не самый старый элемент, то доступ к нему будет за Θ(n)
2. Используется больше памяти

