# team-management-service

### Пользователи:

- **GET /users** - Получить список всех пользователей.
- **POST /users** - Создать нового пользователя.
- **GET /users/{id}** - Получить информацию о пользователе по его ID.
- **PUT /users/{id}** - Обновить информацию о существующем пользователе.
- **PATCH /users/{id}** - Частично обновить информацию о пользователе (например, обновить только email).
- **DELETE /users/{id}** - Удалить пользователя по его ID.
- **GET /users?username={username}** - Найти пользователей по юзернейму.
- **GET /users?search={query}** - Общий поиск по различным полям пользователя (юзернейм, email и т.д.).

### Команды:

- **GET /teams** - Получить список всех команд.
- **POST /teams** - Создать новую команду.
- **GET /teams/{id}** - Найти команду по идентификатору.
- **PUT /teams/{id}** - Обновить команду по идентификатору.
- **PATCH /teams/{id}** - Частично обновить команду (например, обновить только описание).
- **DELETE /teams/{id}** - Удалить команду по идентификатору.
- **GET /teams?name={teamName}** - Найти команду по названию.
- **DELETE /teams?name={teamName}** - Удалить команду по названию.

### Участники команд (teammates):

- **GET /teams/{team_id}/teammates** - Получить список участников команды.
- **POST /teams/{team_id}/teammates** - Добавить нового участника в команду.
- **GET /teams/{team_id}/teammates/{teammate_id}** - Получить информацию об участнике команды.
- **PUT /teams/{team_id}/teammates/{teammate_id}** - Обновить данные участника команды (включая роль).
- **PATCH /teams/{team_id}/teammates/{teammate_id}** - Частично обновить данные участника (например, обновить только
  роль).
- **DELETE /teams/{team_id}/teammates/{teammate_id}** - Удалить участника из команды.

### Управление приглашениями:

- **POST /teams/{team_id}/invite** - Создать приглашение для присоединения к команде (генерирует уникальную ссылку или
  код).
  - **GET /teams/join/{invite_code}** - Участник использует эту ссылку или код для присоединения к команде.

    посмотреть команды в которых юзер
    teams/search?userId

    а ищем пользователя с помощью
    /users?search=noTeamId=1      