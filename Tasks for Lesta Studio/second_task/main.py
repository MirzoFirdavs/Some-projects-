import random
import typing

''' Cyclic queue based on an array. '''


class ArrayQueue:
    def __init__(self):
        self.queue = [None, None]
        self._head = 0
        self._size = 0

    def enqueue(self, value):
        if self._size == len(self.queue):
            i = 0

            queue_copy = [None for _ in range(len(self.queue))]

            while i < len(self.queue):
                queue_copy[i] = self.queue[(self._head + i) % len(self.queue)]
                i += 1

            self.queue = queue_copy[:] + [None for _ in range(len(self.queue))]
            self.queue[self.get_size()] = value
            self._head = 0
        elif (self._head + self._size) % len(self.queue) == len(self.queue):
            self.queue[0] = value
        else:
            self.queue[(self._head + self._size) % len(self.queue)] = value

        self._size += 1

    def dequeue(self) -> typing.Any:
        cur = self.get_head()

        self.queue[self._head] = None
        self._head = (self._head + 1) % len(self.queue)
        self._size -= 1

        return cur

    def get_head(self) -> typing.Any:
        return self.queue[self._head]

    def get_size(self) -> int:
        return self._size

    def is_empty(self) -> bool:
        return self._size == 0

    def clear(self):
        self.queue = [None, None]
        self._size = 0
        self._head = 0

    def get_peek(self) -> typing.Any:
        if (self._head + self._size) % len(self.queue) == 0:
            return self.queue[len(self.queue) - 1]
        else:
            return self.queue[(self._head + self._size) % len(self.queue) - 1]


''' Cyclic queue based on a linked list. '''


class LinkedQueue:
    def __init__(self):
        self.__head = None
        self.__tail = None
        self.__size = 0

    def dequeue(self) -> typing.Any:
        res = self.get_head()

        self.__head = self.__head.next
        self.__size -= 1

        return res

    def get_head(self) -> typing.Any:
        if self.get_size() != 0:
            return self.__head.value
        else:
            raise ValueError("There is no elements")

    def enqueue(self, value):
        if self.get_size() == 0:
            self.__head = self.Node(value)
            self.__tail = self.__head
        else:
            self.__tail.next = self.Node(value)
            self.__tail = self.__tail.next

        self.__size += 1

    def get_size(self) -> int:
        return self.__size

    def get_peek(self) -> typing.Any:
        return self.__tail.value

    def clear(self):
        self.__tail = None
        self.__head = None
        self.__size = 0

    def is_empty(self) -> bool:
        return self.__size == 0

    class Node:
        def __init__(self, val=None, _next=None):
            self.value = val
            self.next = _next


def testing(queue):
    for i in range(15):
        queue.enqueue("__" + chr(random.randint(32, 47)) + chr(random.randint(58, 126)) + "__string")

    print("Peek is: ", queue.get_peek())
    print("Size is: ", queue.get_size())
    print()
    print("The first value is: ", queue.get_head())
    print()

    while not queue.is_empty():
        print(queue.dequeue())

    print()
    print(queue.is_empty())


def test_array_queue():
    array_queue = ArrayQueue()
    testing(array_queue)


def test_linked_queue():
    linked_queue = LinkedQueue()
    testing(linked_queue)


if __name__ == '__main__':
    test_array_queue()
    print("#######################################")
    test_linked_queue()
