package me.jay.Java2175;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Main {
    private static final String BASE_PACKAGE = "me.jay.Java2175";
    private static final ClassLoader CLASS_LOADER = Thread.currentThread().getContextClassLoader();

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<PackageInfo> packages = scanPackages();

        while (true) {
            printPackages(packages);
            System.out.print("Enter index to execute (e.g., 1-2) or 0 to exit: ");
            String input = scanner.nextLine().trim();

            if (input.equals("0")) {
                break;
            }

            String[] parts = input.split("-");
            if (parts.length == 2) {
                try {
                    int packageIndex = Integer.parseInt(parts[0]);
                    int classIndex = Integer.parseInt(parts[1]);

                    PackageInfo pkg = packages.get(packageIndex - 1);
                    String className = pkg.getClassByIndex(classIndex);

                    if (className != null) {
                        String fullClassName = BASE_PACKAGE + "." + pkg.name + "." + className;

                        execute(fullClassName);
                        scanner.nextLine();
                    }
                } catch (NumberFormatException | IndexOutOfBoundsException ignore) {
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            clearConsole();
        }
    }

    private static List<PackageInfo> scanPackages() throws IOException {
        List<PackageInfo> packageList = new ArrayList<>();
        Enumeration<URL> resources = CLASS_LOADER.getResources(BASE_PACKAGE.replace(".", "/"));

        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            File dir = new File(resource.getFile());

            if (dir.isDirectory()) {
                scanDirectory(dir, packageList);
            }
        }

        return packageList;
    }

    private static void scanDirectory(File dir, List<PackageInfo> packageList) {
        File[] files = dir.listFiles();

        if (files == null || files.length == 0) {
            return;
        }

        String dirName = dir.getName();
        List<String> classNames = new ArrayList<>();

        for (File file : files) {
            if (file.isDirectory()) {
                scanDirectory(file, packageList);
            } else if (file.getName().endsWith(".class") && !file.getName().equals("Main.class")) {
                classNames.add(file.getName().replace(".class", ""));
            }
        }

        if (!classNames.isEmpty() && !dirName.equals("Java2175")) {
            packageList.add(new PackageInfo(dirName, classNames));
        }
    }

    private static void printPackages(List<PackageInfo> packages) {
        for (int i = 0; i < packages.size(); i++) {
            PackageInfo pkg = packages.get(i);

            System.out.printf("(%d) %s\n", i + 1, pkg.name);
            for (int j = 0; j < pkg.classNames.size(); j++) {
                System.out.printf("\t[%d] %s\n", j + 1, pkg.classNames.get(j));
            }
        }
    }

    private static void execute(String fullClassName) throws Exception {
        Class<?> clazz = Class.forName(fullClassName);

        clazz.getMethod("main", String[].class).invoke(null, (Object) new String[]{});
    }

    // For IDEA IDE
    private static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private static class PackageInfo {
        String name;
        List<String> classNames;

        PackageInfo(String name, List<String> classNames) {
            this.name = name;
            this.classNames = classNames;
        }

        String getClassByIndex(int index) {
            if (index < 1 || index > classNames.size()) {
                return null;
            }

            return classNames.get(index - 1);
        }
    }
}
