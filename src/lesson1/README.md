# Чтение файлов

Чтобы прочитать файл, необходимо воспользоваться классом 
```
File f = new File();
```


```
createNewFile() - создает новый файл, если такого не существует
delete() - удаляет файл или директорию
deleteOnExists() - удаляет файл или директорию после нормального завершения программы
length() -   длина файла
```
Само же чтение файлов(содержимое) осуществляется с помощью наследников
абстрактных классов 
```
InputStream;
OutputStream
```
Эти классы сделаны абстрактыми, чтобы не привязываться к какому-то конкретному источнику данных.
У каждого класса есть наследники.

У класса

```
InputStream;
```
есть наследники
```
FileInputStream - чтение  байт из файла; 
ByteArrayInputStream - чтение байт из байтового массива
BufferedInputStream - буферизированный поток ввода
PushBackInputStream - буферизированный поток ввода с механизмом возврата в поток
SequenceInputStream -  может объединять нессколько потоков ввода типа InputStream
```

У любого из этих классов, а также у других наследников  класса InputStream
есть методы

```
int available() - количество доступных для чтения байт
void mark(int bytes) - оставляет метку, пока не будет прочитано заданное количество байт
int read() - читает байт. Если возвращает - 1 - читать нечего
int read(byte [] b) - записывает байты в массив. Возвращает количество прочитанных байт 
```


У класса

```
OutputStream;
```
есть наследники
```
FileOutputStream - чтение  байт из файла; 
ByteArrayOutputStream - чтение байт из байтового массива
BufferedOutputStream - буферизированный поток ввода
PushBackOutputStream - буферизированный поток ввода с механизмом возврата в поток
SequenceOutputStream -  может объединять нессколько потоков ввода типа InputStream
```

## FileInputStream

```
FileInputStream(File f)
FileInputStream(FileDescriptor f) ex FileInputStream(FileDescriptor.in)
FileInputStream(String name)
```

методы
```
int available() - сколько доступно байт для чтения
void close() - 
FileChannel  getChannel() - возвращает файловый  канал

```
Пример
```
FileInputStream fis = new FileInputStream(new File("text.txt"));

```

###ByteArrayInputStream

```
ByteArrayInputStream(byte array[])
ByteArrayInputStream(byte array[], int start, int length)
```

Метод close() - можно и не вызывать

Есть еще доп методы mark(int i) и   reset()

###PushbackInputStream 
Позволяет просматривать  бегло поток ввода-вывода и выяснить, что потупит из него в следующий раз, фактически не извлекая данные

```
PushbackInputStream(InputStream is)
PushbackInputStream(InputStream is, int bytes)
```
Методы
```
void unread(int b)
void unread(byte[] buffer)
void unread(byte[] buffer, int offset,  int bytes)-  чтение со смещением
```
###SequenceInputStream
Позволяет соединить несколько потоков ввода типа InputStream
```
SequenceInputStream(InputStream i1, InpustStream i2)
SequenceInputStream(Enumeration <? extends InputStream>)
```
для помощи используется
```
InputStreamEnumerator(Collection c)
```


#Outpustream
Методы класса и его наследников
```
close() - закрывает поток
void flush() - записывает в файл соодержимое потока, сбрасывая буфер вывода
write(int b) - записывает единственный байт в поток вывода
write(int byte[])
write(int byte[], int offset)
```

## FileOutputStream

```
FileOutputStream(File f)
FileOutputStream(String file) 

FileOutputStream(File f, boolean flag) - поддерживает добавление к существующему файлу
FileOutputStream(String file, boolean flag) - поддерживает добавление к существующему файлу 
```

###ByteArrayOutputStream

```
ByteArrayOutputStream()
ByteArrayOutputStream( int length)
```


###PrintStream
Когда мы пишем  System.out, мы обращаемся к классу PrintStream

###RandomAcessFile
Никого не наследует. Может начать работать в рандомном месте файла с помощью метода seek(long postion)
#
Классы для чтения/записи символов

Почти те же самые названия классы, но вместо Inpustream ->Reader
Вместо Outputstream -> Writer

##Reader

```
clone() - закрывает файл
mark(int length) - размещает метку, которая действует пока не будет прочитано length символов
int read() - читает символ. Если нет символа - возвращает -1
int read(char buffer[])
int read(CharSequence c)
int read(char buffer[], int offsset, int length) - чтение со смещением. Абстрактный
reset() - перемещает указатель на поставленную метку
skip(long length) - пропускает length символов 

```

###Writer
```
void append(char c)
Writer append(CharSequuence c)
abstract void close()
abstract void flush()
void write(int c)
void write(char buffer[])
abstract void write(String s)

abstract void write(String s, int offset, int length)
```

##Console