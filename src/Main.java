void main() {
  Scanner scanner = new Scanner(System.in);
  String[] products = {"Хлеб", "Яюлоко", "Молоко", "Яйца", "Колбаса"};
  int[] price = { 50, 25, 80, 210, 290 };
  int[] basketCount = new int[products.length];
  int totalSum = 0;

  for (int i = 0; i < products.length; i++){
    System.out.println((i+1) + ". " + products[i] + "\t\t" + price[i] + " руб./шт.");
  }

  System.out.println("Введите номер товара и количество товара через 'пробел'");

  while (true){
    //Ввод команды 'end' или 'конец' приводит к завершению программы
    String input = scanner.nextLine();
    if ("end".equals(input) || "конец".equals(input)){
      break;
    }

    String[] parts = input.split(" ");  // Разбиваем ввод пользователя на две части

    if (parts.length != 2) {
      System.out.println("Пожалуйста, введите два числа: номер товара и количество.");
      continue;
    }

    int productNumber = Integer.parseInt(parts[0]) - 1; // -1, так как индексы с нуля
    int productCount = Integer.parseInt(parts[1]);

    basketCount[productNumber] += productCount;
  }

  System.out.println("\\nВаша корзина:");
  System.out.println("Наименование товара\t\tКоличество\t\tЦена/ед\t\tОбщая стоимость");

  for (int i = 0; i < products.length; i++)
  {
    // Вывод только тех товары, которые купили (количество > 0)
    if (basketCount[i] > 0)
    {
      int currentItemSum = basketCount[i] * price[i];
      totalSum += currentItemSum;

      System.out.println(products[i] + "\t\t\t\t\t\t" + basketCount[i] + "\t\t\t" + price[i] + "\t\t\t" + currentItemSum + " руб./шт.");
    }
  }

  System.out.println("______________________________________________________________");
  System.out.println("ИТОГО:\t\t\t\t\t\t\t\t\t\t\t\t" + totalSum + " руб./шт.");
}
