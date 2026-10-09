public class Rectangle{
    double height;
    double  width;

     Rectangle(double height, double width){
        this.height = height;
        this.width = width;
    }
    double area(){
        return height * width;
    }
        double  perimeter(){
            return 2 * (height + width);
        }
        public static void main(String[] args){
            Rectangle[] rectangles = {
            new Rectangle(4,3),
            new Rectangle(3,5),
            new Rectangle(4,4),
            new Rectangle(3,2),
            new Rectangle(6,6)
        };
     Rectangle largest = rectangles[0];
        for (Rectangle r : rectangles){
            if (r.area() > largest.area())
                largest = r;
            }
            System.out.println("largest:" + largest.height + "x" + largest.width + "area =" + largest.area());
            // ex 4 : prediction and explanation
            Rectangle r1 = new Rectangle(5,6);
            Rectangle r2 = r1;
            r2.width = 99;
            System.out.println("r1,width = " + r1.width);

        }

            
    
}