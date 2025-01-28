# This is the final Doc for the Project


## Testfälle für die Todo-Manager-Anwendung

## 1. Hinzufügen eines neuen To-Dos
**Beschreibung**: Überprüfen, ob das Hinzufügen eines neuen To-Dos korrekt funktioniert.

- **Eingabe**:
    - Titel: "Einkaufen"
    - Beschreibung: "Milch und Brot kaufen"
    - Kategorie: "Einkauf"
- **Erwartetes Ergebnis**:
    - Das To-Do "Einkaufen" mit der Beschreibung "Milch und Brot kaufen" und der Kategorie "Einkauf" wird der Liste hinzugefügt.
    - Das To-Do erscheint in der ListView.

## 2. Markieren eines To-Dos als erledigt
**Beschreibung**: Überprüfen, ob ein To-Do korrekt als erledigt markiert wird.

- **Eingabe**:
    - Ein To-Do ist in der ListView angezeigt.
    - Auswahl eines To-Dos und Klicken auf den "Markieren als erledigt"-Button.
- **Erwartetes Ergebnis**:
    - Das To-Do wird mit einem "✔" vor dem Titel angezeigt.
    - Der Status des To-Dos wird auf "erledigt" gesetzt.

## 3. Entfernen eines To-Dos
**Beschreibung**: Überprüfen, ob ein To-Do korrekt entfernt wird.

- **Eingabe**:
    - Ein To-Do ist in der ListView angezeigt.
    - Auswahl eines To-Dos und Klicken auf den "Todo entfernen"-Button.
- **Erwartetes Ergebnis**:
    - Das ausgewählte To-Do wird aus der ListView entfernt.
    - Das To-Do wird aus der `todoList`-Datenstruktur entfernt.

## 4. Suchen von To-Dos nach Kategorie
**Beschreibung**: Überprüfen, ob die Suchfunktion korrekt nach To-Dos in einer bestimmten Kategorie filtert.

- **Eingabe**:
    - Eingabe der Kategorie "Einkauf" im Suchfeld.
    - Klick auf den "Suchen"-Button.
- **Erwartetes Ergebnis**:
    - Alle To-Dos, die zur Kategorie "Einkauf" gehören, werden in der ListView angezeigt.
    - Andere To-Dos werden nicht angezeigt.

## 5. Zurücksetzen der To-Do-Liste
**Beschreibung**: Überprüfen, ob die Liste nach dem Klicken auf den "Zurücksetzen"-Button korrekt wiederhergestellt wird.

- **Eingabe**:
    - Einige To-Dos wurden hinzugefügt und nach Kategorie gefiltert.
    - Klick auf den "Zurücksetzen"-Button.
- **Erwartetes Ergebnis**:
    - Alle To-Dos werden wieder angezeigt.
    - Der Suchfilter wird zurückgesetzt.

## 6. Speichern der To-Dos in einer Datei
**Beschreibung**: Überprüfen, ob die To-Dos korrekt in einer Datei gespeichert werden.

- **Eingabe**:
    - Zwei To-Dos wurden hinzugefügt:
        - "Einkaufen" (Kategorie: "Einkauf")
        - "Hausaufgaben" (Kategorie: "Schule")
    - Die Anwendung wird geschlossen.
- **Erwartetes Ergebnis**:
    - Die To-Dos werden in einer Datei namens `todos.txt` gespeichert, wobei jedes To-Do im Format `Titel|Beschreibung|Kategorie|Status` gespeichert wird.

## 7. Laden der To-Dos aus einer Datei
**Beschreibung**: Überprüfen, ob die To-Dos korrekt aus einer Datei geladen werden.

- **Eingabe**:
    - Eine Datei `todos.txt` enthält die folgenden Daten:
      ```
      Einkaufen|Milch und Brot kaufen|Einkauf|false
      Hausaufgaben|Mathematikaufgaben lösen|Schule|true
      ```
    - Anwendung starten.
- **Erwartetes Ergebnis**:
    - Die To-Dos "Einkaufen" und "Hausaufgaben" werden korrekt in die ListView geladen.
    - Das To-Do "Hausaufgaben" wird als erledigt angezeigt (✔).

## 8. Fehlerbehandlung beim Laden einer Datei
**Beschreibung**: Überprüfen, ob beim Laden einer Datei mit ungültigem Format oder beim Fehlen der Datei keine Ausnahme auftritt.

- **Eingabe**:
    - Die Datei `todos.txt` existiert nicht oder ist beschädigt (z.B. fehlende Trennzeichen oder unvollständige Zeilen).
- **Erwartetes Ergebnis**:
    - Die Anwendung startet ohne Fehler.
    - Es werden keine To-Dos geladen, aber die Anwendung funktioniert weiterhin.

## 9. Leere Eingabefelder beim Hinzufügen eines To-Dos
**Beschreibung**: Überprüfen, ob das Hinzufügen eines To-Dos mit leeren Eingabefeldern nicht möglich ist.

- **Eingabe**:
    - Titel: ""
    - Beschreibung: ""
    - Kategorie: ""
    - Klick auf den "Todo hinzufügen"-Button.
- **Erwartetes Ergebnis**:
    - Es wird kein To-Do hinzugefügt.
    - Es erfolgt keine Änderung in der To-Do-Liste.

## 10. To-Do mit gleichen Werten hinzufügen
**Beschreibung**: Überprüfen, ob das Hinzufügen eines To-Dos mit gleichen Werten (Titel, Beschreibung, Kategorie) mehrere Instanzen desselben To-Dos erlaubt.

- **Eingabe**:
    - Titel: "Einkaufen"
    - Beschreibung: "Milch und Brot kaufen"
    - Kategorie: "Einkauf"
    - Klick auf den "Todo hinzufügen"-Button (mehrmals).
- **Erwartetes Ergebnis**:
    - Mehrere Instanzen des gleichen To-Dos ("Einkaufen") werden zur Liste hinzugefügt.

