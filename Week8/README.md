# Week 8 — Object Modeling & Workflows

Solutions for both Week 8 PDFs:
- `Assignment/`: Hostel Laundry Queue; Assignment Submission Portal; Campus Premiere Ticket Counter; FitZone Membership Desk; Campus Notice Broadcaster.
- `Practice/`: Vehicle Rental System; Employee Leave Request Workflow; Online Examination System; Hotel Booking System; Payment Processing for a Shopping System.

Each problem is implemented in its own standalone Java file with a matching public class. Compile/run example:

```bash
javac Week8/Assignment/Problem1_HostelLaundryQueue.java
java -cp Week8/Assignment Problem1_HostelLaundryQueue
```

Use Java 8+. Dates use `java.time`. Pricing values for Week 8 practice examples are not specified in the PDF (it uses $X/$Y), so the examples use clearly illustrative rates rather than claiming source-provided amounts. Cancellation deadlines and policy thresholds are supplied to constructors so they can be configured by the caller.