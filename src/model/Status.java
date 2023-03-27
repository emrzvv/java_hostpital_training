package model;

import conversation.Messages;

import java.util.NoSuchElementException;

public enum Status {
    SERIOUSLY_ILL {
        @Override
        public String toString() {
            return "\"Тяжело болен\"";
        }
    },
    ILL {
        @Override
        public String toString() {
            return "\"Болен\"";
        }
    },
    SLIGHTLY_ILL {
        @Override
        public String toString() {
            return "\"Слегка болен\"";
        }
    },
    DISCHARGE_READY {
        @Override
        public String toString() {
            return "\"Готов к выписке\"";
        }
    },
    DISCHARGED {
        @Override
        public String toString() {
            return "\"Выписан\"";
        }
    };

    public Status next() {
        if (ordinal() == values().length - 1) {
            throw new NoSuchElementException(Messages.errorAlreadyDischarged);
        }
        return values()[ordinal() + 1];
    }

    public Status previous() {
        if (ordinal() == 0) {
            throw new NoSuchElementException(Messages.errorStatusDown);
        }
        return values()[ordinal() - 1];
    }
}
