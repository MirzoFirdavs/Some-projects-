import random


def is_even(value):
    return value % 2 == 0


def my_is_even(value):
    return not (value & 1)


def print_is_even():
    for i in range(100):
        a = random.randint(1, 10000)

        if my_is_even(a):
            print(str(a) + " is Even")
        else:
            print(str(a) + " is Odd")


if __name__ == '__main__':
    print_is_even()

