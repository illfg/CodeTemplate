package util;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
        name = "loginState",
        storages = {
                @Storage(StoragePathMacros.NON_ROAMABLE_FILE)
        }
)
public class PersistentValue implements PersistentStateComponent<PersistentValue.State> {

    @Nullable
    @Override
    public State getState() {
        return null;
    }

    @Override
    public void loadState(@NotNull State state) {

    }

    static class State{
        String username;
        String password;

        public State() {
        }

        public State(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    State state;

}
