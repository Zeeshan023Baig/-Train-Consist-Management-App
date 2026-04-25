public class Train {

    // ✅ Custom Runtime Exception
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // ✅ Goods Bogie
    static class GoodsBogie {
        String type;   // Cylindrical / Rectangular
        String cargo;  // Petroleum / Coal / etc.

        GoodsBogie(String type) {
            this.type = type;
        }

        // ✅ Safe cargo assignment using try-catch-finally
        public void assignCargo(String cargo) {
            try {
                // ❌ Rule: Rectangular cannot carry Petroleum
                if (type.equalsIgnoreCase("Rectangular") &&
                        cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException(
                            "Unsafe: Rectangular bogie cannot carry Petroleum"
                    );
                }

                // ✅ Assign if safe
                this.cargo = cargo;
                System.out.println("Cargo assigned: " + type + " -> " + cargo);

            } catch (CargoSafetyException e) {
                // ✅ Handle safely (no crash)
                System.out.println("Error: " + e.getMessage());

            } finally {
                // ✅ Always runs
                System.out.println("Assignment attempt completed.\n");
            }
        }

        @Override
        public String toString() {
            return type + " -> " + (cargo == null ? "No Cargo" : cargo);
        }
    }

    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println(" UC15 - Safe Cargo Assignment ");
        System.out.println("=========================================\n");

        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        // ✅ Safe assignment
        b1.assignCargo("Petroleum");

        // ❌ Unsafe assignment (handled)
        b2.assignCargo("Petroleum");

        // ✅ Program continues
        b2.assignCargo("Coal");

        System.out.println("Final State:");
        System.out.println(b1);
        System.out.println(b2);

        System.out.println("\nProgram continues safely...");
    }
}