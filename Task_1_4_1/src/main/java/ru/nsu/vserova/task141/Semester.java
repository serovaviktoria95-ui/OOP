package ru.nsu.vserova.task141;

import java.util.ArrayList;
import java.util.List;

/** Класс для семестра. */
public class Semester {
    private final int num;
    private final List<GradeRecord> records;
    private boolean completed;

    /** Создать запись о семестре. */
    public Semester(int num) {
        this.num = num;
        this.records = new ArrayList<>();
        this.completed = false;
    }

    /** Добавить запись об аттестации в семестр. */
    public void addRecord(GradeRecord record) {
        records.add(record);
    }

    /** Получить список записей об аттестации в семестре. */
    public List<GradeRecord> getRecords() {
        return records;
    }

    /** Окончен семестр или нет. */
    public boolean isCompleted() {
        return completed;
    }

    /** Номер семестра. */
    public int getNum() {
        return num;
    }

    /** Устанавливает признак завершения семестра. */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
