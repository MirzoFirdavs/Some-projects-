# A. Лучшее приближение 

Не решена Расстояние Хэмминга (кодовое расстояние) — число позиций, в которых соответствующие символы двух слов одинаковой длины различны. В более общем случае расстояние Хэмминга применяется для строк одинаковой длины любых -ичных алфавитов и служит метрикой различия (функцией, определяющей расстояние в метрическом пространстве) объектов одинаковой размерности. Вам даны пары бинарных строк одинаковой длины (max(hamming(s, t), hamming(d, t)). Найдите бинарную строку , для которой величина минимальна.Если бинарных строк минимизирующих данную величину несколько, выведите любую из них.

### Формат ввода

В первой строке записаны два целых числа и (1 ≤ n ≤ 25 1 ≤ q ≤ 100 000) — длина строк в наборе тестовых данных и количество тестовых пар. 

В каждой из следующих строк записаны две бинарные строки и длины . Строки разделены одиночным пробелом.

### Формат вывода 

Для каждой из тестовых пар выведите найденную строку . Тестовые пары нужно обрабатывать в порядке следования во входных данных.

### Пример 1
    
#### Ввод
    5 3
    01000 00110
    00000 11111
    00001 00111

#### Вывод
    01100
    01010
    00011

### Пример 2

#### Ввод
    1 1
    1 1

#### Вывод
    1

### Пример 3

#### Ввод
    2 10
    00 00
    00 01
    00 10
    00 11
    01 01
    01 10
    01 11
    10 10
    10 11
    11 11

#### Вывод
    00
    00
    00
    01
    01
    00
    01
    10
    10
    11

### Ограничение памяти                                        Ограничение времени
256.0 Мб                                                      4 с

### Ввод                                                      Вывод
стандартный ввод или input.txt                                стандартный вывод или output.txt

# B. Сложный массив 

Дан массив , элементами которого могут быть целые числа или массивы такой же структуры. Некоторые массивы могут быть пустыми или содержать только один вложенный массив. Например массив может иметь следующую структуру: [1, 2, 3, [5, 5], 6, [7, 8, 9, [10, 11]]]. Если интерпретировать массив как простую последовательность чисел, определите элементы в массиве, который встречается наибольшее количество раз.

### Формат ввода

В единственной строке записано представление массива. Элементы массива (числа и массивы) разделены запятой и пробелом. Перед первым элементом каждого массива записан символ '[', после последнего элемента записан символ ']'.

Гарантируется, что все числа по абсолютной величине менее 100 000 000. В массиве есть хотя бы одно число.

Размер входных данных не превышает 1MB.

### Формат вывода 

Выведите все числа, которые встречаются в массиве наибольшее количество раз. Числа нужно выводить в порядке возрастания, разделяя одиночными пробелами.

### Пример 1
    
#### Ввод
    [1, 2, 3, [5, 5], 6, [7, 8, 9, [10, 11]]]

#### Вывод
    5

### Пример 2

#### Ввод
    [[[[[[1]]]], []]]

#### Вывод
    1

### Пример 3

#### Ввод
    [5, 5, 1, 3, 1, 2]

#### Вывод
    1 5

### Пример 4

#### Ввод
    [0, 10, 2, 5, -999999999]

#### Вывод
    -999999999 0 2 5 10

### Ограничение памяти                                        Ограничение времени
256.0 Мб                                                      2 с

### Ввод                                                      Вывод
стандартный ввод или input.txt                                стандартный вывод или output.txt

# C. i10n

Для некоторых терминов с большим количество букв принято использовать сокращения: *l10n* вместо *localization* или *i18n* вместо *internationalization*. Вам дан набор из строк длиной не более 20 символов. Для каждой строки *w* определим сокращение *pNs*, где *p* – некоторый непустой префикс строки *w*, *s* – некоторый непустой суффикс строки *w*, – *N* целое число больше единицы,
которое задает количество пропущенных букв между префиксом и суффиксом. Будем рассматривать только такие сокращения, где длины *p* и *s* совпадают. Из всех сокращений для каждого слова из набора найдите такое, что никакое другое слово не может быть сокращено таким же образом.

### Формат ввода

В первой строке записаны число (1 ≤ n ≤ 50 000).

В каждой из следующих строк записано одно слово (*w* 4 ≤ ∣*w*∣ ≤ 20). Все слова различны и состоят только маленьких букв английского алфавита.

### Формат вывода 

Выведите *n* строк, по одной строке для каждого слова из входных данных (в порядке следования во входных данных) – минимальное по длине подходящее под условие задачи сокращение, если подходящего сокращения нет, выведите слово без сокращения.

### Пример 1
    
#### Ввод
    2
    localization
    internationalization

#### Вывод
    l10n    
    i18n

### Пример 2

#### Ввод
    4
    banana
    apple
    potato
    tomato

#### Вывод
    b4a
    a3e
    p4o
    t4o

### Пример 3

#### Ввод
    10
    aaaa
    abaa
    abab
    bbbb
    baba
    aaaaaaaaaaaaaaaaaaaa
    abaaaaaaaaaaaaaaaaaa
    bbbbbbbbbbbbbbbbbbbb
    sjfdhlsakdjfhsald
    sdfasdfsadfafdsfdd

#### Вывод
    aaaa
    abaa
    a2b
    b2b
    b2a
    aa16aa
    ab16aa
    b18b
    s15d
    s16d

### Ограничение памяти                                        Ограничение времени
256.0 Мб                                                      4 с

### Ввод                                                      Вывод
стандартный ввод или input.txt                                стандартный вывод или output.txt

# D. Arithmetics Inc. 

Компания Arithmetics Inc. разрабатывает программное обеспечение для работы с бесконечными арифметическими прогрессиями. Необходимо разработать структуру данных, которая будет хранить арифметические прогрессии и поддерживать следующие операции:
* Операция первого типа позволяет добавить новую арифметическую прогрессию в структуру.
* Операция второго типа позволяет удалить заданную арифметическую прогрессию из cтруктуры.
* Операция третьего типа находит арифметическую прогрессию с минимальным первым элементом и возвращает найденный элемент, предварительно заменив стартовый элемент в прогрессии на следующей в ней. Если таких прогрессий несколько, то обрабатывается прогрессия, у которой минимальный идентификатор.

### Формат ввода

На вход подается одно целое положительное число q (1 ≤ q ≤ 100 000) — количество операций.

Далее на вход подаются q строк в следующем формате: 

* Если это операция первого типа, то на вход подаются четыре числа 1. a1, d, id (0 ≤ ∣a 1∣, ∣d∣ ≤ 100 000 000, 1 ≤ id ≤ 100 000 000) — первый элемент и разность добавляемой прогрессии, а также ее идентификатор.

* Если это операция второго типа, то на вход подаются два числа 2, id — идентификатор прогрессии, которую необходимо удалить.

* Если это операция третьего типа, то на вход подается одно число 3. В этот момент хотя бы одна прогрессия будет находиться в структуре. 

Гарантируется, что все id арифметических прогрессий различны. Удаляемая прогрессия, гарантированно находится в структуре данных.

### Формат вывода 

Выведите ответы на каждый запрос третьего типа по одному в строке.

### Пример 1
    
#### Ввод
    15
    1 3 -4 1
    1 -5 4 3
    1 -2 10 2
    33
    2 3
    33
    2 2
    1 -5 4 4
    3
    2 1
    333

#### Вывод
    -5
    -2
    3
    -1
    -5
    -5
    -1
    3

### Ограничение памяти                                        Ограничение времени
256.0 Мб                                                      2 с

### Ввод                                                      Вывод
стандартный ввод или input.txt                                стандартный вывод или output.txt