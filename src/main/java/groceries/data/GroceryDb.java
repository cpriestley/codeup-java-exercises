package groceries.data;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroceryDb {
    private final Set<String> categories;
    private final Map<String, List<String>> items;

    public GroceryDb() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        String path = "src/main/resources/grocery.yml";
        FileInputStream inputStream = new FileInputStream(path);
        Object data = yaml.load(inputStream);
        items = (Map<String, List<String>>) data;
        categories = items.keySet();
    }

    public Set<String> getCategories() {
        return categories;
    }

    public Map<String, List<String>> getItems() {
        return items;
    }

}



