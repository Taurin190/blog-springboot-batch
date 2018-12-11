# blog-springboot-batch
blog-springbootで作ったサイトをGKEに置いてみたものの、データを入れる方法の一つとして作成。

GUIで作れるものをblog-posterとして作ってみたものの、時間もかかりそうなので、
持っているデータをDBに入れるものを作ります。

## 検討中のポイント
- entityを共通化するかは要検討
- ワンタイムで使うものなので、Docker化してKubernetesのCronJob等で使うのが良いかも