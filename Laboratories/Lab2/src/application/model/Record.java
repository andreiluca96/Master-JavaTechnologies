package application.model;

import java.util.Objects;

public class Record {
    private String name;
    private Category category;

    public Record(String name, Category category) {
        this.name = name;

        if (category == null) {
            this.category = Category.DEFAULT;
        }
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(name, record.name) &&
                category == record.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}
