Задача: "Большие гонки".
Условия задачи...
Случайным образом генерируется маршрут (Нью-Йорк-Париж), ландшафт которого представляет собой массив, переменно идущих подряд, целых чисел: 1 - асфальт; 2 - песок; 3 - снег; 4 - вода; 5 - лава; 6 - воздух; N - и т.п... Например: 00000005555552222222222122222220000000000000044444.... и т.д.

Создаются несколько вездеходных автомобилей, но в разной степени приспособленных для движения по разным ландшафтам. Например:

Car[1]: для пересечения 1км по асфальту тратит N секунд, а для пересечения 1км по воде - M секунд...
Car[2]: для пересечения 1км асфальта тратит X секунд, а для пересечения 1км по воде тратит Y секунд…
Car[n]: и т.д. для 4х, 6х, или 8 автомобилей.
Элементы массива маршрута, время для прохождения разных ландшафтов разными машинами – каждый запуск программы должны быть случайными положительными числами. (Число машин/потоков тоже можно сделать случайным.)

Задача заключается в том, чтобы «устроить гонку» и определить победителей.

Основная программа создаёт для каждого автомобиля отдельный поток.
Каждый автомобиль в своём потоке перебирает элементы маршрута один за другим, останавливая поток ( Thread.sleep() ) на то количество секунд, которое требуется для пересечения 1км текущего типа дороги.
Основная программа выводит на экран результаты первых трёх автомобилей/потока, которые добрались до финиша (т.е. поток завершил своё выполнение).
Практические навыки: Java Multithreading, Java Random.
