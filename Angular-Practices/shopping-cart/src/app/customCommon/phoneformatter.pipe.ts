import { Pipe, PipeTransform } from "@angular/core";
@Pipe({
    name: 'phoneformatter'
})
export class PhoneFormatter implements PipeTransform {
    transform(input: any, filteringCriteria: any = 'USA') {
        if (isNaN(input)) {
            return input;
        }
        if (input.toString().length == 10) {
            input = input.toString();
            if (filteringCriteria == "INR") {
                input = "+91-" + input.substring(0, 5) + "-" + input.substring(5);
            }
            else {
                input = "+1-" + input.substring(0, 3) + "-" + input.substring(3, 6) + "-" + input.substring(6);
            }

        }

        return input;

    }
}
