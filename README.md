Обработчик формы отправки email
POST /email
{
"email": yourEmail,
"subject": someSubj,
"message": someMessage
}
Полученные данные нужно:
● Сохранить в базе
● Отправить в очередь сообщений
Рекомендуемые инструменты:
Java, Spring Boot, Spring Data
