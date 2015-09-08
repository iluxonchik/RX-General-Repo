import rx.Observable;
import rx.Subscriber;

/**
 * Based on this blog post series: http://blog.danlew.net/2014/09/15/grokking-rxjava-part-1/
 */

public class Main {

    public static void main(String [] args) {

        // A basic Observable that emits "Hello World" when someone subscribes to it
        Observable<String> simpleObservable = Observable.create(
                new Observable.OnSubscribe<String>() {

                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("Hello, world");
                        subscriber.onCompleted();
                    }
                }
        );

        // A basic Subscriber to consume the data. All it does is emit a string emitted by the observable
        Subscriber<String> simpleSubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };

        simpleObservable.subscribe(simpleSubscriber);
    }
}
