import NavBar from "../comp/navbar";

export default function Layout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <div className="flex flex-row">
      <NavBar />
      {children}
    </div>
  );
}
